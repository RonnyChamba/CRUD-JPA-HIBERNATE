let $numBoletos = document.getElementById("numBoletos");
let $subtotal = document.getElementById("subtotal");
let $total = document.getElementById("total");
let $selectLugar = document.getElementById("destino-js");


$numBoletos.addEventListener("change", ()=> calcularValores());


$selectLugar.addEventListener("change",()=> calcularValores());

function calcularValores(){
	
	let numBoletos =  Number.parseInt($numBoletos.value);

	let optionSelected = $selectLugar.options[$selectLugar.selectedIndex];
	
	let precio = optionSelected.dataset.precio;
	
	let subtotal = numBoletos*precio;
	
	let iva = (subtotal *12)/100;
	
	let total = subtotal + iva;
		
	$subtotal.value = subtotal;
	$total.value=total;
	
}
