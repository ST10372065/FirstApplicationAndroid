package vcmsa.projects.firstapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import vcmsa.projects.firstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var order = Order()


    //private lateinit var sb1: ImageView

    class Order(){
        lateinit var productName: String
        lateinit var customerName: String
        lateinit var customerCell: String
        lateinit var orderDate: String

        //secondary constuctor
        constructor(pName: String) : this(){
            productName = pName
        }

        // secondary constuctor
        constructor(pName: String, cName: String, cCell: String, oDate: String) :this(pName){
            customerName = cName
            customerCell = cCell
            orderDate = oDate
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //longer way opf doing code
        /*binding.imgSb1.setOnClickListener {
            Toast.makeText(this, "Soy Latte", Toast.LENGTH_SHORT).show()
        }

        binding.imgSb2.setOnClickListener {
            Toast.makeText(this, "Choco Frapp", Toast.LENGTH_SHORT).show()
        }

        binding.imgSb3.setOnClickListener {
            Toast.makeText(this, "Bottled Americano", Toast.LENGTH_SHORT).show()
        }

        binding.imgSb4.setOnClickListener {
            Toast.makeText(this, "Rainbow Latte", Toast.LENGTH_SHORT).show()
        }

        binding.imgSb5.setOnClickListener {
            Toast.makeText(this, "Caramel Frapp", Toast.LENGTH_SHORT).show()
        }

        binding.imgSb6.setOnClickListener {
            Toast.makeText(this, "Black Forest Frapp", Toast.LENGTH_SHORT).show()
        }*/
        //shorter way of doing the code
        binding.imgSb1.setOnClickListener(this)
        binding.imgSb2.setOnClickListener(this)
        binding.imgSb3.setOnClickListener(this)
        binding.imgSb4.setOnClickListener(this)
        binding.imgSb5.setOnClickListener(this)
        binding.imgSb6.setOnClickListener(this)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


    }


//tester
    override fun onClick(v: View?) {
        when (v?.id){

//            R.id.img_sb1 -> Toast.makeText(this,"MMM Soy Latte",Toast.LENGTH_SHORT).show()
//            R.id.img_sb2 -> Toast.makeText(this,"MMM Chocco Frapp",Toast.LENGTH_SHORT).show()
//            R.id.img_sb3 -> Toast.makeText(this,"MMM Bottled Americano",Toast.LENGTH_SHORT).show()
//            R.id.img_sb4 -> Toast.makeText(this,"MMM Rainbow Frapp",Toast.LENGTH_SHORT).show()
//            R.id.img_sb5 -> Toast.makeText(this,"MMM Caramel Frapp",Toast.LENGTH_SHORT).show()
//            R.id.img_sb6 -> Toast.makeText(this,"MMM Black Forest Frapp",Toast.LENGTH_SHORT).show()

            R.id.img_sb1 -> order.productName = "Soy Latte"
            R.id.img_sb2 -> order.productName = "Chocco Frapp"
            R.id.img_sb3 -> order.productName = "Bottled Americano"
            R.id.img_sb4 -> order.productName = "Rainbow Frapp"
            R.id.img_sb5 -> order.productName = "Caramel Frapp"
            R.id.img_sb6 -> order.productName = "Black Forest Frapp"
        }
        Toast.makeText(this@MainActivity,"MMM" + order.productName, Toast.LENGTH_SHORT).show()
        openIntent(applicationContext, order.productName,OrderDetailsActivity::class.java)
    }
}





