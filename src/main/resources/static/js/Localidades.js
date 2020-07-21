
function cboProvincia() {
	$("#Distrito").html("<option>Seleccionar Tu Distrito</option>");
	$.post("listaProvincia", $("#data").serialize(), function(data) {
		$("#Provincia").html(data)
	});
}

function cboDistrito() {
	$.post("listaDistrito", $("#data").serialize(), function(data) {
		$("#Distrito").html(data)
	})
}