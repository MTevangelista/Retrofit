package br.projeto.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.projeto.retrofit.model.Pokemon
import br.projeto.retrofit.services.PokemonServices
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retofit.create(PokemonServices::class.java)

        service.all().enqueue(object: Callback<List<Pokemon>>{
            override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
                txtVwHome.text = t.message
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
                var pokemons = response.body()
                txtVwHome.text = pokemons?.size.toString()
//                Toast.makeText(baseContext, "${pokemons!!.get()}", Toast.LENGTH_LONG).show()
            }
        })

//        service.show(10).enqueue(object : Callback<Pokemon>{
//            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
//            }
//
//            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
//            }
//
//        })
    }
}
