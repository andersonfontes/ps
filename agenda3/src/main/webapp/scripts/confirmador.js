/**
 * 
 */



function confirmar(idcon) {

	let resposta = confirm("confirma a exclusao deste contato?")
	if (resposta === true) {
		window.location.href = "delete?idcon=" + idcon
	} else {
		close()
	}
}