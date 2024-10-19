//alert("Hello")
console.log("patientUpdate");

document.addEventListener('DOMContentLoaded', function(){
    document.getElementById('updateProcedure').onclick = function(event){
        event.preventDefault()
        updatePhone()
    }
})

function updateProcedure(){
    console.log ("updateProcedure")
}