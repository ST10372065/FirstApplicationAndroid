package vcmsa.projects.firstapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.projects.firstapplication.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {

    var order = MainActivity.Order()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_details)
        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get the name of the ordered product from the intent
        order.productName = intent.getStringExtra("order").toString()

        //set the product name on the text view
        binding.txtOrderedBev.text = order.productName

        when(order.productName){
            "Soy Latte" -> binding.imgOrderedBev.setImageResource(R.drawable.sb1)
            "Chocco Frapp" -> binding.imgOrderedBev.setImageResource(R.drawable.sb2)
            "Bottled Americano" -> binding.imgOrderedBev.setImageResource(R.drawable.sb3)
            "Rainbow Frapp" -> binding.imgOrderedBev.setImageResource(R.drawable.sb4)
            "Caramel Frapp" -> binding.imgOrderedBev.setImageResource(R.drawable.sb5)
            "Black Forest Frapp" -> binding.imgOrderedBev.setImageResource(R.drawable.sb6)

        }

        binding.FABOrder.setOnClickListener(){
            shareIntent(applicationContext, order.productName)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}