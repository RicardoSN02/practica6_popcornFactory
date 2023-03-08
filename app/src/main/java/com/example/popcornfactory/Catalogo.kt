package com.example.popcornfactory

import android.content.Context
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Catalogo : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        var adapter:PeliculaAdapter? = null
        var peliculas = ArrayList<Pelicula>()
        val gridview: GridView = findViewById(R.id.gridview)

        fun cargarPeliculas(){
            peliculas.add(Pelicula("Big Hero 6",R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called ‘Big Hero 6.’",arrayListOf<Cliente>()))
            peliculas.add(Pelicula("Inception",R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.",arrayListOf<Cliente>()))
            peliculas.add(Pelicula("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged.", arrayListOf<Cliente>()))
            peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home.",arrayListOf<Cliente>()))
            peliculas.add(Pelicula("1917",R.drawable.war, R.drawable.warheader,"On 6 April 1917, aerial reconnaissance has observed that the German army, which has pulled back from a sector of the Western Front in northern France, is not in retreat but has made a strategic withdrawal to the new Hindenburg Line, where they are waiting to overwhelm the British with artillery.",arrayListOf<Cliente>()))
            peliculas.add(Pelicula("Men in black",R.drawable.mib, R.drawable.mibheader, "After a government agency makes first contact with aliens in 1961, alien refugees live in secret on Earth by disguising themselves as humans. Men in Black (MIB) is a secret agency that polices these aliens, protects Earth from extraterrestrial threats, and uses memory-erasing neuralyzers to keep alien activity a secret. MIB agents have their former identities erased while retired agents are neuralyzed. ",arrayListOf<Cliente>()))

            peliculas.add(Pelicula("Dr. house",R.drawable.drhouse,R.drawable.househeader,"The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory\n" +
                    "House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try\n" +
                    "to cure complex and rare diseases from very ill ordinary people in the United States of America.",arrayListOf<Cliente>()))
            peliculas.add(Pelicula("Dr.who",R.drawable.drwho,R.drawable.drwhoheader,"Traveling across time and space, the immortal time-lord known as &#39;The Doctor&#39; travels across the\n" +
                    "universe with his many companions and his loyal shape-shifting space-ship: The TARDIS. The\n" +
                    "Doctor faces many threats across many generations: from The Daleks, The Cybermen and his time-\n" +
                    "lord adversary The Master to the sinister Davros, creator of The Daleks.",arrayListOf<Cliente>()))
            peliculas.add(Pelicula("Friends",R.drawable.friends,R.drawable.friendsheader,"Rachel Green, Ross Geller, Monica Geller, Joey Tribbiani, Chandler Bing and Phoebe Buffay are\n" +
                    "six 20 something year-olds, living off of one another in the heart of New York City. Over the course\n" +
                    "of ten years, this average group of buddies goes through massive mayhem, family trouble, past and\n" +
                    "future romances, fights, laughs, tears and surprises as they learn what it really means to be a\n" +
                    "friend.",arrayListOf<Cliente>()))
            peliculas.add(Pelicula("Smallville",R.drawable.smallville,R.drawable.smallvilleheader,"The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions amongst\n" +
                    "colonials of Smallville. Interestingly, the boy has managed to downplay his acts of various heroic\n" +
                    "egresses in the past. They say he&#39;s either too fast or has a penchant for finding trouble. He was\n" +
                    "found by Martha and Jonathan Kent on the day of the Meteor Shower, and subsequently adopted.\n" +
                    "Clark&#39;s friend Lex Luthor, the only heir of Luthorcorp, has been secretly investigating grounds for\n" +
                    "Clark&#39;s outlandish valor. However, on the face of it, Clark just seems a normal boy who&#39;s slightly\n" +
                    "more secretive than usual.",arrayListOf<Cliente>()))
        }

        cargarPeliculas()

        adapter= PeliculaAdapter(peliculas,this)
        gridview.adapter = adapter



    }

    class PeliculaAdapter: BaseAdapter {

        var peliculas = ArrayList<Pelicula>()
        var context: Context? = null

        constructor(peliculas: ArrayList<Pelicula>,context: Context?) : super() {
            this.peliculas = peliculas
            this.context = context
        }


        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var pelicula= peliculas[position]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.pelicula,null)

            var iv_pelicula: ImageView = vista.findViewById(R.id.iv_pelicula)
            var tv_titulo: TextView = vista.findViewById(R.id.tv_titulo)

            iv_pelicula.setImageResource(pelicula.image)
            tv_titulo.setText(pelicula.titulo)

            iv_pelicula.setOnClickListener(){
                var intent = Intent(context,detalle_pelicula::class.java)
                intent.putExtra("nombre",pelicula.titulo)
                intent.putExtra("image",pelicula.image)
                intent.putExtra("header",pelicula.header)
                intent.putExtra("sinopsis",pelicula.sinopsis)
                intent.putExtra("numberSeats",(20-pelicula.arreglo.size).toString())
                context!!.startActivity(intent)
            }

            return vista
        }

    }
}