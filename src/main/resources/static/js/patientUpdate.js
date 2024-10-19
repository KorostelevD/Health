//alert("Hello")
//console.log("patientUpdate");

/* document.addEventListener('DOMContentLoaded', function(){
    document.getElementById('updateProcedure').onclick = function(event){
        event.preventDefault()
        updatePhone()
    }
}) */

//const forms  = document.querySelectorAll('#form-container tr form')
const forms  = document.querySelectorAll('#form-container form')

forms.forEach(function(form){
    form.addEventListener('submit',function(event){
        event.preventDefault()
        updateProcedure(form)
    })
})

function updateProcedure(form){
    let formData = new FormData(form)
    let json = JSON.stringify(Object.fromEntries(formData))
    console.log(json)
    //
    fetch('/rest/procedureUpdateForm', {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body:json
    })
    .then(json => {
        console.log(json)
    })
    .catch(error =>{
        console.log(error)
    })
    
}