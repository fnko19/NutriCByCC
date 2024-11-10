package com.example.bismillah.features

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.bismillah.ui.theme.Poppins
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.Query
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.res.painterResource
import com.example.bismillah.R

@Composable
fun PerkembanganScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        val firestore = FirebaseFirestore.getInstance()

        var journalEntries by remember { mutableStateOf<List<JournalEntry>>(emptyList()) }
        var showInputDialog by remember { mutableStateOf(false) }
        var newEntryDate by remember { mutableStateOf("") }
        var newEntryNotes by remember { mutableStateOf("") }
        var showEditDialog by remember { mutableStateOf(false) }
        var selectedEntry by remember { mutableStateOf<JournalEntry?>(null) }

        // Load journal entries
        LaunchedEffect(user) {
            user?.let {
                firestore.collection("users").document(it.uid)
                    .collection("journalEntries")
                    .orderBy("date", Query.Direction.DESCENDING)
                    .addSnapshotListener { snapshot, _ ->
                        if (snapshot != null) {
                            journalEntries = snapshot.documents.mapNotNull { doc ->
                                val entry = doc.toObject(JournalEntry::class.java)
                                entry?.copy(id = doc.id)  // Menambahkan ID dokumen
                            }
                        }
                    }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        "Jurnal Perkembangan Anak",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = Poppins
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(journalEntries) { entry ->
                    JournalCard(entry, onCardClick = {
                        selectedEntry = entry
                        newEntryDate = entry.date
                        newEntryNotes = entry.notes
                        showEditDialog = true
                    })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { showInputDialog = true },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Tambahkan Data", color = Color.Black, fontWeight = FontWeight.Bold, fontFamily = Poppins)
            }
        }

        // Input dialog for adding new entry
        if (showInputDialog) {
            AlertDialog(
                onDismissRequest = { showInputDialog = false },
                title = { Text("Tambahkan Catatan", fontFamily = Poppins) },
                text = {
                    Column {
                        TextField(
                            value = newEntryDate,
                            onValueChange = { newEntryDate = it },
                            label = { Text("Tanggal (dd/mm/yyyy)", fontFamily = Poppins) }
                        )
                        TextField(
                            value = newEntryNotes,
                            onValueChange = { newEntryNotes = it },
                            label = { Text("Catatan", fontFamily = Poppins) }
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            user?.let {
                                val entryData = JournalEntry(
                                    date = newEntryDate,
                                    notes = newEntryNotes
                                )
                                firestore.collection("users").document(it.uid)
                                    .collection("journalEntries")
                                    .add(entryData)
                                    .addOnSuccessListener {
                                        showInputDialog = false
                                        newEntryDate = ""
                                        newEntryNotes = ""
                                    }
                                    .addOnFailureListener {
                                        // Handle failure
                                    }
                            }
                        }
                    ) {
                        Text("Simpan", fontFamily = Poppins)
                    }
                },
                dismissButton = {
                    Button(onClick = { showInputDialog = false }) {
                        Text("Batal", fontFamily = Poppins)
                    }
                }
            )
        }

        // Edit Dialog for selected entry
        if (showEditDialog && selectedEntry != null) {
            AlertDialog(
                onDismissRequest = { showEditDialog = false },
                title = { Text("Edit Catatan", fontFamily = Poppins) },
                text = {
                    Column {
                        TextField(
                            value = newEntryDate,
                            onValueChange = { newEntryDate = it },
                            label = { Text("Tanggal (dd/mm/yyyy)", fontFamily = Poppins) }
                        )
                        TextField(
                            value = newEntryNotes,
                            onValueChange = { newEntryNotes = it },
                            label = { Text("Catatan", fontFamily = Poppins) }
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            user?.let {
                                val entryData = JournalEntry(
                                    date = newEntryDate,
                                    notes = newEntryNotes,
                                    id = selectedEntry!!.id // Gunakan ID yang dipilih untuk memperbarui dokumen
                                )
                                firestore.collection("users").document(it.uid)
                                    .collection("journalEntries")
                                    .document(selectedEntry!!.id)  // Gunakan ID dokumen yang dipilih
                                    .update(
                                        "date", newEntryDate,
                                        "notes", newEntryNotes
                                    )
                                    .addOnSuccessListener {
                                        showEditDialog = false
                                        newEntryDate = ""
                                        newEntryNotes = ""
                                    }
                                    .addOnFailureListener {
                                        // Handle failure
                                    }
                            }
                        }
                    ) {
                        Text("Update", fontFamily = Poppins)
                    }
                },
                dismissButton = {
                    Button(onClick = { showEditDialog = false }) {
                        Text("Batal", fontFamily = Poppins)
                    }
                }
            )
        }
    }
}

@Composable
fun JournalCard(entry: JournalEntry, onCardClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Color.White)
            .clickable { onCardClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = entry.date,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontFamily = Poppins,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = entry.notes)
        }
    }
}

data class JournalEntry(
    val date: String = "",
    val notes: String = "",
    val id: String = "" // Tambahkan id untuk menyimpan ID dokumen
)

