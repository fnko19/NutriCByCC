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
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgsigniu), // Ganti dengan resource gambar background Anda
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Sign In Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            // Avatar or logo image at the top
            Image(
                painter = painterResource(id = R.drawable.logocrop),
                contentDescription = "Logo",
                modifier = Modifier.size(240.dp)
            )
            Spacer(modifier = Modifier.height(0.dp))

            Text(
                text = "Login to Your Account",
                fontFamily = Poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email TextField
            TextField(
                value = userViewModel.userData.collectAsState().value.name, // Ambil nama dari ViewModel
                onValueChange = { name ->
                    userViewModel.updateUserData(name, userViewModel.userData.value.email, userViewModel.userData.value.password)
                },
                placeholder = {
                    Text(
                        text = "Name",
                        fontFamily = Poppins,
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
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
                value = userViewModel.userData.collectAsState().value.email, // Ambil email dari ViewModel
                onValueChange = { email ->
                    userViewModel.updateUserData(userViewModel.userData.value.name, email, userViewModel.userData.value.password)
                },
                placeholder = {
                    Text(
                        text = "Email",
                        fontFamily = Poppins,
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sign In Button
            Button(
                onClick = {
                    navController.navigate("home"){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = SandyBrown, // Warna background button
                    contentColor = Color.White // Warna teks button
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Sign In",  fontFamily = Poppins, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Or Sign In With",
                fontFamily = Poppins,
                fontSize = 12.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Google Sign In Button (simulated as an OutlinedButton)
            Image(
                painter = painterResource(id = R.drawable.google), // Ganti dengan id drawable logo Google
                contentDescription = "Google Logo",
                modifier = Modifier
                    .size(50.dp) // Sesuaikan ukuran logo
                    .clickable(onClick = { /* Handle Google Sign In */ })
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sign Up Option
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically // Pastikan kedua teks sejajar secara vertikal
            ) {
                Text(text = "Don’t have an account?", color = Color.Black, fontSize = 14.sp, fontFamily = Poppins)
                TextButton(
                    onClick = { navController.navigate("signup") },
                    contentPadding = PaddingValues(0.dp) // Hilangkan padding default pada TextButton
                ) {
                    Text(text = "Sign Up", color = Color.Blue, fontSize = 14.sp, fontFamily = Poppins)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))


        }
        Image(
            painter = painterResource(id = R.drawable.tulisan),
            contentDescription = "TulisanLogo",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomCenter)
                //.padding(bottom = 16.dp)
        )
    }
}

@Preview
@Composable
fun SignInPreview() {
    SigninScreen(navController = rememberNavController())
}
