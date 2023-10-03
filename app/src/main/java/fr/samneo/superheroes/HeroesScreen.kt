package fr.samneo.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.samneo.superheroes.data.Heroes
import fr.samneo.superheroes.model.Hero
import fr.samneo.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(modifier.clip(MaterialTheme.shapes.medium)) {
        Row(
            Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        ) {
            Column(Modifier.weight(1f)) {
                Text(stringResource(id = hero.name), style = MaterialTheme.typography.displaySmall)
                Text(
                    stringResource(id = hero.description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(id = hero.image),
                null,
                Modifier
                    .padding(start = dimensionResource(id = R.dimen.padding_medium))
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )

        }
    }
}

@Composable
fun HeroItemList(heroes: List<Hero>, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        items(heroes) { hero ->
            HeroItem(
                hero = hero, Modifier.padding(bottom = 8.dp, start= 16.dp, end = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun HeroItemListPreview() {
    SuperheroesTheme {
        HeroItemList(Heroes.heroes)
    }
}

@Preview
@Composable
fun HeroItemListDarkThemePreview() {
    SuperheroesTheme (useDarkTheme = true){
        HeroItemList(Heroes.heroes)
    }
}

@Preview
@Composable
fun HeroItemPreview() {
    SuperheroesTheme {
        HeroItem(Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
    }
}