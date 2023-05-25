$(document).ready(function() {
    function limpa_formulário_cep() {
        // Limpa valores do formulário de cep.
        $("#ruaAvenida").val("");
        $("#bairro").val("");
        $("#cidade").val("");
        $("#estado").val("");
    }
    
    //Quando o campo cep perde o foco.
    $("#cep").blur(function() {

        //Nova variável "cep" somente com dígitos.
        var cep = $(this).val().replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if(validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                $("#ruaAvenida").val("...");
                $("#bairro").val("...");
                $("#cidade").val("...");
                $("#estado").val("...");

                //Consulta o webservice viacep.com.br/
                $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                    if (!("erro" in dados)) {
                        //Atualiza os campos com os valores da consulta.
                        $("#ruaAvenida").val(dados.logradouro);
						if(dados.logradouro != "")
						$("#ruaAvenida").prop( "readonly", true );
						else
						$("#ruaAvenida").prop( "readonly", false );
						
                        $("#bairro").val(dados.bairro);
						if(dados.bairro != "")
						$("#bairro").prop( "readonly", true );
						else
						$("#bairro").prop( "readonly", false );						
						
                        $("#cidade").val(dados.localidade);
						if(dados.localidade != "")
						$("#cidade").prop( "readonly", true );
						else
						$("#cidade").prop( "readonly", false );
						
                        $("#estado").val(dados.uf);
						if(dados.uf != "")
						$("#estado").prop( "readonly", true );
						else
						$("#estado").prop( "readonly", false );
                    } //end if.
                    else {
                        //CEP pesquisado não foi encontrado.
                        limpa_formulário_cep();
                        alert("CEP não encontrado.");
                    }
                });
            } //end if.
            else {
                //cep é inválido.
                limpa_formulário_cep();
                alert("Formato de CEP inválido.");
            }
        } //end if.
        else {
            //cep sem valor, limpa formulário.
            limpa_formulário_cep();
        }
    });
});