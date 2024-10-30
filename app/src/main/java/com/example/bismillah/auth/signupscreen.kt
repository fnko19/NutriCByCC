package com.example.bismillah.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bismillah.R
import com.example.bismillah.ui.theme.Poppins
import com.example.bismillah.ui.theme.SandyBrown
import com.example.bismillah.user.UserViewModel
import androidx.compose.foundation.clickable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import com.example.bismillah.user.UserData
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun SignupScreen(navController: NavController, userViewModel: UserViewModel = viewModel()){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        // Background Image
//        Image(
//            painter = painterResource(id = R.drawable.bglogin), // Ganti dengan resource background gambar Anda
//            contentDescription = "Background Image",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.fillMaxSize()
//        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Create Your Account",
                fontFamily = Poppins,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Name TextField
            TextField(
                value = userViewModel.userData.collectAsState().value.name,
                onValueChange = { name ->
                    userViewModel.updateUserData(name, userViewModel.userData.value.email, userViewModel.userData.value.password)
                },
                placeholder = {
                    Text(
                        text = "Name",
                        fontFamily = Poppins,
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFF1C9),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email TextField
            TextField(
                value = userViewModel.userData.collectAsState().value.email,
                onValueChange = { email ->
                    userViewModel.updateUserData(userViewModel.userData.value.name, email, userViewModel.userData.value.password)
                },
                placeholder = {
                    Text(
                        text = "Email",
                        fontFamily = Poppins,
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFF1C9),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password TextField
            TextField(
                value = userViewModel.userData.collectAsState().value.password,
                onValueChange = { password ->
                    userViewModel.updateUserData(userViewModel.userData.value.name, userViewModel.userData.value.email, password)
                },
                placeholder = {
                    Text(
                        text = "Password",
                        fontFamily = Poppins,
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFF1C9),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sign Up Button
            Button(
                onClick = {
                    navController.navigate("home") {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color(0xFFFFA500)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(5.dp, Color(0xFFFFA500))
            ) {
                Text(
                    text = "Sign Up",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFA500) // Warna teks oranye
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Or Sign Up With",
                fontFamily = Poppins,
                fontSize = 12.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Google Sign Up Button (simulated as an Image)
            Image(
                painter = painterResource(id = R.drawable.google), // Ganti dengan id drawable logo Google
                contentDescription = "Google Logo",
                modifier = Modifier
                    .size(35.dp)
                    .clickable(onClick = { /* Handle Google Sign Up */ })
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Sign In Option
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Already have an account?", color = Color.Black, fontSize = 12.sp, fontFamily = Poppins)
                TextButton(
                    onClick = { navController.navigate("signin") },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Sign In", color = Color.Blue, fontSize = 12.sp, fontFamily = Poppins)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.chatbot), // Ganti dengan resource robot Anda
                contentDescription = "Robot Logo",
                modifier = Modifier
                    .size(120.dp) // Sesuaikan ukuran sesuai kebutuhan
                    .padding(bottom = 16.dp) // Padding bawah untuk sedikit jarak dari tepi layar
            )
        }



        // Tulisan Logo di Bawah
        Image(
            painter = painterResource(id = R.drawable.tulisan), // Ganti dengan resource logo tulisan Anda
            contentDescription = "Tulisan Logo",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp) // Padding bawah untuk memposisikan logo
        )
    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignupScreen(navController = rememberNavController())
}
