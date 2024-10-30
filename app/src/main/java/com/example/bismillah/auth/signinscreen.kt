package com.example.bismillah.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.R
import com.example.bismillah.ui.theme.Poppins
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.bismillah.ui.theme.SandyBrown
import androidx.compose.foundation.clickable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bismillah.user.UserViewModel
import androidx.compose.runtime.collectAsState
import com.example.bismillah.user.UserData
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


@Composable
fun SigninScreen(navController: NavController, userViewModel: UserViewModel = viewModel()) {
    val userData by userViewModel.userData.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.bgloginv2), // Ganti dengan resource gambar background Anda
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Sign In Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 0.dp)
                .align(Alignment.TopCenter), // Menempatkan konten di bagian tengah atas
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(240.dp)) // Memberikan jarak dari atas

            // Avatar atau gambar robot di bagian atas
//            Image(
//                painter = painterResource(id = R.drawable.robotsi),
//                contentDescription = "Logo",
//                modifier = Modifier.size(200.dp) // Ukuran gambar robot
//            )

            Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp), // Padding untuk konten dalam kartu
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Login to Your Account",
                        fontFamily = Poppins,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Email TextField
                    TextField(
                        value = userViewModel.userData.collectAsState().value.name,
                        onValueChange = { name ->
                            userViewModel.updateUserData(name, userViewModel.userData.value.email, userViewModel.userData.value.password)
                        },
                        placeholder = {
                            Text(text = "Email", fontFamily = Poppins, fontSize = 14.sp)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFFFFF1C9),
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Password TextField
                    TextField(
                        value = userViewModel.userData.collectAsState().value.email,
                        onValueChange = { email ->
                            userViewModel.updateUserData(userViewModel.userData.value.name, email, userViewModel.userData.value.password)
                        },
                        placeholder = {
                            Text(text = "Password", fontFamily = Poppins, fontSize = 14.sp)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFFFFF1C9),
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sign In Button
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
                            backgroundColor = Color(0xFFFFD54F), // Warna button sesuai contoh
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Sign In", fontFamily = Poppins, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "Or Sign In With",
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Google Sign In Button
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google Logo",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable(onClick = { /* Handle Google Sign In */ })
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Sign Up Option
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Don’t have an account?", color = Color.Black, fontSize = 14.sp, fontFamily = Poppins)
                        TextButton(
                            onClick = { navController.navigate("signup") },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(text = "Sign Up", color = Color.Blue, fontSize = 14.sp, fontFamily = Poppins)
                        }
                    }

                }
        }
        Image(
            painter = painterResource(id = R.drawable.tulisan),
            contentDescription = "TulisanLogo",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun SignInPreview() {
    SigninScreen(navController = rememberNavController())
}
