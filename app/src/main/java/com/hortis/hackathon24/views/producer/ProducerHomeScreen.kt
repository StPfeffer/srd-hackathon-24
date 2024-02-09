package com.hortis.hackathon24.views.producer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hortis.hackathon24.components.announcement.HorizontalAnnouncementCard
import com.hortis.hackathon24.components.seemore.SeeMore
import com.hortis.hackathon24.components.text.Title

@Composable
fun ProducerHomeScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    ConstraintLayout {
        val (topImg, profile) = createRefs()

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(
                    state = rememberScrollState()
                )
                .fillMaxWidth()
        ) {
            Title(text = "Meus compromissos")

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (i in 0..2) {
                    HorizontalAnnouncementCard()
                    Spacer(
                        modifier.padding(top = 8.dp)
                    )
                }

                SeeMore(
                    text = "Ver mais compromissos"
                )
            }

            Title(text = "Anúncios abertos")

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (i in 0..2) {
                    HorizontalAnnouncementCard()
                    Spacer(
                        modifier.padding(top = 8.dp)
                    )
                }

                SeeMore(
                    text = "Ver mais compromissos"
                )
            }
        }
    }
}