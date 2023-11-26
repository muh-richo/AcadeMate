package com.example.academate.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.academate.R
import com.example.academate.model.ListMentor
import com.example.academate.ui.theme.AcadeMateTheme

@Composable
fun ShowMentor(listMentor: ListMentor) {
    Card (
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = listMentor.imgProfil),
                contentDescription = null,
                modifier = Modifier.size(75.dp)
            )
            Column {
                Text(
                    text = stringResource(id = listMentor.namaMentor),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = stringResource(id = listMentor.matkulMentor),
                    fontSize = 14.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Lihat Mentor",
                        fontSize = 14.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = colorResource(id = R.color.blue1)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowNullMentor() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Maaf, belum ada mentor untuk mata kuliah yang anda cari.",
            textAlign = TextAlign.Center
        )
    }
}

//@Preview (showBackground = true)
//@Composable
//fun ShowMentorPreview() {
//    AcadeMateTheme {
//        ShowMentor(listMentor = ListMentor(R.drawable.arif, R.string.arif, R.string.jst))
//    }
//}

@Preview (showBackground = true)
@Composable
fun ShowNullMentorPreview() {
    AcadeMateTheme {
        ShowNullMentor()
    }
}