package com.example.polyfilms;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    public List<String> titres = new ArrayList(Arrays.asList("Alita", "Cats", "Conjuring 3","Damien veut changer le monde", "Dora et la cité perdue","Fast and furious 8","Les grands esprits","Rendez-vous chez les malawas","Once upon a time in Hollywood","La dernière vie de Simon","Sol","La vie scolaire"));

    public List<String> dates = new ArrayList(Arrays.asList("13 Février 2019", "25 décembre 2019", "16 Septembre 2020", "6 mars 2019", "14 août 2019",
            "7 août 2019", "13 septembre 2017", "25 décembre 2019", "14 août 2019", "5 février 2020",
            "8 janvier 2020", "28 août 2019"));

    public List<String> durees = new ArrayList(Arrays.asList("2h02", "1h51", "2h30", "1h41", "1h43", "2h16", "1h46", "1h40", "2h41", "1h43", "1h38", "1h51"));

    public List<String> acteurs = new ArrayList(Arrays.asList("Avec Rosa Salazar et Christoph Waltz",
            "Avec Francesca Hayward et Jennifer Hudson,",
            "Avec Patrick Wilson et Vera Farmiga",
            "Avec Franck Gastambide et Melisa Sözen",
            "Avec Isabela Merced et Michael Peña",
            "Avec Dwayne Johnson et Jason Statham",
            "Avec Denis Podalydès et Léa Drucker,",
            "Avec Christian Clavier et Michaël Youn",
            "Avec Leonardo DiCaprio et Brad Pitt",
            "Avec Benjamin Voisin et Camille Claris",
            "Avec Chantal Lauby et Camille Chamoux",
            "Avec Zita Hanrot et Liam Pierron"
    ));


    public List<String> synopsis = new ArrayList(Arrays.asList("Lorsqu’Alita se réveille sans aucun souvenir de qui elle est, dans un futur qu’elle ne reconnaît pas, elle est accueillie par Ido, un médecin qui comprend que derrière ce corps de cyborg abandonné, se cache une jeune femme au passé extraordinaire. Ce n’est que lorsque les forces dangereuses et corrompues qui gèrent la ville d’Iron City se lancent à sa poursuite qu’Alita découvre la clé de son passé.",
            "L'adaptation de la comédie musicale Cats. Une fois par an au cours d’une nuit extraordinaire, les Jellicle Cats se réunissent pour leur grand bal. Leur chef, Deuteronome, choisit celui qui pourra entrer au paradis de la Jellicosphère pour renaître dans une toute nouvelle vie.",
            "Le troisième volet de la saga horrifique \"Conjuring\".",
            "Damien et sa sœur Mélanie ont vécu une enfance heureuse, bercée par les engagements militants de leurs parents. Lorsque leur mère disparait brutalement, la fibre militante de cette famille s'éteint. Vingt ans plus tard, Damien, est devenu pion dans une école primaire, et mène une vie tranquille. Pour sauver l'un de ses jeunes élèves Bahzad, et sa mère, d'une expulsion de territoire imminente...",
            "Après des années à explorer la jungle avec ses parents, Dora se prépare à vivre l’épreuve la plus difficile de sa vie : l’entrée au lycée ! Son âme d’exploratrice ressurgit quand elle doit voler à la rescousse de ses parents en danger.\n" +
                    "Accompagnée de son fidèle singe Babouche, de son cousin Diego et de nouveaux amis hauts en couleur, Dora embarque dans une folle aventure qui l’amènera à percer le mystère de la Cité d’or perdue.",
            "Depuis que Hobbs, fidèle agent de sécurité au service diplomatique des Etats-Unis, combatif mais droit, et Shaw, un homme sans foi ni loi, ancien membre de l’élite militaire britannique, se sont affrontés en 2015 dans Fast & Furious 7 ; les deux hommes font tout ce qu’ils peuvent pour se nuire l’un à l’autre.",
            "François Foucault, la quarantaine est professeur agrégé de lettres au lycée Henri IV, à Paris. Une suite d’évènements le force à accepter une mutation d’un an dans un collège de banlieue classé REP +. Il redoute le pire. A juste titre.",
            "Pour la spéciale Noël de son émission phare Rencontre au bout du bout du monde, Léo Poli emmène non pas un, mais quatre invités exceptionnels. Est-ce vraiment une bonne idée? Nos stars partent à la rencontre des Malawas, une des tribus les plus isolées du monde. Une comédie sur la nature… humaine.",
            "En 1969, la star de télévision Rick Dalton et le cascadeur Cliff Booth, sa doublure de longue date, poursuivent leurs carrières au sein d’une industrie qu’ils ne reconnaissent plus. ",
            "Simon a 8 ans, il est orphelin. Son rêve est de trouver une famille prête à l’accueillir. Mais Simon n’est pas un enfant comme les autres, il a un pouvoir secret : il est capable de prendre l’apparence de chaque personne qu’il a déjà touchée… Et vous, qui seriez-vous si vous pouviez vous transformer ?",
            "Sol, célèbre interprète de Tango argentin, vit à Buenos-Aires depuis de nombreuses années. Derrière son tempérament excessif et son sourire incandescent, la Diva cache une blessure dont elle ne s’est jamais réellement remise : la perte de son fils unique, Raphaël, avec qui elle avait rompu tout lien. Sol revient à Paris dans l’espoir de rencontrer enfin Jo, son petit-fils de 7 ans, né de l’union de Raphaël et d’Eva, sa belle-fille, qu’elle ne connaît pas.",
            "Une année au coeur de l'école de la république, de la vie... et de la démerde ! Samia, jeune CPE novice, débarque de son Ardèche natale dans un collège réputé difficile de la ville de Saint-Denis. Elle y découvre les problèmes récurrents de discipline, la réalité sociale pesant sur le quartier, mais aussi l'incroyable vitalité et l'humour, tant des élèves que de son équipe de surveillants. Parmi eux, il y a Moussa, le Grand du quartier et Dylan le chambreur."
    ));

    public String nomAffiche="affiche_01";
    public int INDEX_AFFICHE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public String recupInformations(){
        Intent intent = getIntent();
        String nomImage = intent.getStringExtra("nomImage");

        return nomImage;
    }

}