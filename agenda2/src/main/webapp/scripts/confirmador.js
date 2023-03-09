/**
 * Confirmação de exclusao de um contato
 @author Anderson
 */

function confirmar(idcon) {
	
	let resposta = confirm("Confirma a a exclusao deste contato?")
	if (resposta===true){
		window.location.href= "delete?idcon=" + idcon
		/**TESTE alert(idcon)**/
		} else {
			close()			
		}
	}
	