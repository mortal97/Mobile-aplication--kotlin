package com.example.divisas

import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.divisas.ui.theme.DivisasTheme
import kotlin.math.roundToInt
import androidx.compose.material3.DropdownMenuItem as DropdownMenuItem1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DivisasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   //llamados de las funciones


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}








@Composable
fun Unit(){
    var inputValue by  remember{ mutableStateOf("") }
    var outputValue by  remember{ mutableStateOf("") }
    var inputUnit by  remember{ mutableStateOf("Centimeters") }
    var outputunit by  remember{ mutableStateOf("") }
    var expand1 by  remember{ mutableStateOf(false) }
    var expand2 by  remember{ mutableStateOf(false) }
    val conversion=remember{ mutableStateOf(0.01) }

    fun Unitconverter(){
        val inputvaluedouble=inputValue.toDoubleOrNull()?:0.0
        val  resultado=(inputvaluedouble*conversion.value*100).roundToInt()/100.0
outputValue=resultado.toString()
        
    }


    Column(modifier =Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ) {
        Text(text = "Unit Converter" )
        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(value =inputValue, onValueChange = {
            inputValue=it




        }, label ={ Text(text = "enter value")}
        )

        Spacer(modifier = Modifier.height(10.dp))


        Row {
            Box{
                Button(onClick = { expand1=true}) {



                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown,"ArrowDropDown")

                    Spacer(modifier = Modifier.height(10.dp))

                }
                DropdownMenu(expanded = expand1, onDismissRequest = { expand1=false }) {
                    DropdownMenuItem1(text = { Text(text = "Centimeters") }, onClick = {
                        expand1=false
                        conversion.value=0.01
                        inputUnit="Centimeters"
                        Unitconverter()


                    })

                    DropdownMenuItem1(text = { Text(text = "Meters") }, onClick = {
                        expand1=false
                        conversion.value=1.0
                        inputUnit="Meters"
                        Unitconverter()
                    })

                    DropdownMenuItem1(text = { Text(text = "Feet") }, onClick = {
                        expand1=false
                        conversion.value=0.3048
                        inputUnit="Feet"
                        Unitconverter()

                    })

                    DropdownMenuItem1(text = { Text(text = "Milimeters") }, onClick = {
                        expand1=false
                        conversion.value=0.001
                        inputUnit="Milimeters"
                        Unitconverter()

                    })


                    Unitconverter()
                    
                }



            }
            Spacer(modifier = Modifier.width(20.dp))


            Box{

                Button(onClick = { expand2=true }) {

                    Text(text = "Select ")
                    
                   Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)

                    Spacer(modifier = Modifier.height(10.dp))
                    

                }
                DropdownMenu(expanded = expand2, onDismissRequest = { expand2=false }) {
                    DropdownMenuItem(text = { Text(text = "Centimetris")}, onClick =
                    {
                        expand2=false
                        conversion.value=0.01
                        outputunit="Centimeters"
                    Unitconverter()

                    })

                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = {
                        expand2=false
                        conversion.value=1.0


                        outputunit="Meters"
                        Unitconverter()


                    })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = {
                        outputunit="Feet"
                        expand2=false
                        conversion.value=0.3048
                        Unitconverter()


                    })
                    DropdownMenuItem(text = { Text(text = "Melimeters")}, onClick = {
                        outputunit="Melimeters"
                        expand2=false
                        conversion.value=0.001
                        Unitconverter()

                    })




                    

                }




            }

        }
        Spacer(modifier = Modifier.height(16.dp))
Text(text = "Resultado:")
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DivisasTheme {
        Greeting("Android")

    }





}
@Preview(showBackground =  true)
@Composable
fun unitPreview(){
   Unit()
}
