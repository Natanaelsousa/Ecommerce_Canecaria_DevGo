/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function(){
    
    var msg = document.getElementById("mens").value;
    var elm = document.getElementById("mensagem");
    var inp = document.createElement("input");
    if(msg === "erro"){
        inp.setAttribute("value", "Não foi possível "+req.value+" o "+req.value+" !");
        inp.setAttribute("id", "erro");
        inp.setAttribute("readonly", "readonly");
        elm.appendChild(inp);
    }
    if(msg === "sucesso"){
        inp.setAttribute("value", req.value+" "+act.value+" com sucesso !");
        inp.setAttribute("id", "sucesso");
        inp.setAttribute("readonly", "readonly");
        elm.appendChild(inp);
    }
    else if(msg === "erro"){
        inp.setAttribute("value", "Não foi possível ser "+act.value+" o "+req.value+" !");
        inp.setAttribute("id", "erro");
        inp.setAttribute("readonly", "readonly");
        elm.appendChild(inp);
    }
    req.value = "";
    act.value = "";
    msg.value = "";
    
    var departamento = document.getElementById("departamento").value;
    var menu = document.getElementById("menu");
    if(departamento === "FINANCEIRO"){
        menu.removeChild(menu.childNodes[1]);
        menu.removeChild(menu.childNodes[2]);
    }
    else if(departamento === "SERVICO"){
        menu.removeChild(menu.childNodes[1]);
        menu.removeChild(menu.childNodes[5]);
        menu.removeChild(menu.childNodes[3]);
        menu.removeChild(menu.childNodes[4]);
    }
    else if(departamento === "TECNOLOGIA DA INFORMACAO"){
    }
    else{
    }
}
function somenteNumero(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if (tecla >= 33 && tecla <= 64 )
        return true;
    else
        return false;
}
function somenteLetras(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if (tecla > 47 && tecla < 58 || tecla === 48)
        return false;
    else
        return true;
}

function limpa_formulário_cep() {
//Limpa valores do formulário de cep.
    document.getElementById('rua').value = ("");
    document.getElementById('bairro').value = ("");
    document.getElementById('cidade').value = ("");
    document.getElementById('uf').value = ("");
}

function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
//Atualiza os campos com os valores.
        document.getElementById('rua').value = (conteudo.logradouro);
        document.getElementById('bairro').value = (conteudo.bairro);
        document.getElementById('cidade').value = (conteudo.localidade);
        document.getElementById('uf').value = (conteudo.uf);
        document.getElementById('ibge').value = (conteudo.ibge);
    } //end if.
    else {
//CEP não Encontrado.
        limpa_formulário_cep();
        alert("CEP não encontrado.");
    }
}

function pesquisacep(valor) {

//Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');
    //Verifica se campo cep possui valor informado.
    if (cep !== "") {

//Expressão regular para validar o CEP.
        var validacep = /^[0-9]{8}$/;
        //Valida o formato do CEP.
        if (validacep.test(cep)) {

//Preenche os campos com "..." enquanto consulta webservice.
            document.getElementById('rua').value = "...";
            document.getElementById('bairro').value = "...";
            document.getElementById('cidade').value = "...";
            document.getElementById('uf').value = "...";
            //Cria um elemento javascript.
            var script = document.createElement('script');
            //Sincroniza com o callback.
            script.src = '//viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';
            //Insere script no documento e carrega o conteúdo.
            document.body.appendChild(script);
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
}
function limpa_formulário_cpf() {
    document.getElementById('CPF').value = ("");

}
function limpa_formulário_cnpj() {
    document.getElementById('CNPJ').value = ("");
}
function TestaCPF(n) {
    var Soma;
    var Resto;
    Soma = 0;
    if (n.length !== 11 ||
            n === "00000000000" ||
            n === "11111111111" ||
            n === "22222222222" ||
            n === "33333333333" ||
            n === "44444444444" ||
            n === "55555555555" ||
            n === "66666666666" ||
            n === "77777777777" ||
            n === "88888888888" ||
            n === "99999999999") {
        alert("CPF Invalido!");
        limpa_formulário_cpf();
        return false;
    }

    for (i = 1; i <= 9; i++)
        Soma = Soma + parseInt(n.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11))
        Resto = 0;
    if (Resto !== parseInt(n.substring(9, 10))) {
        alert("CPF Invalido!");
        limpa_formulário_cpf();
        return false;
    }

    Soma = 0;
    for (i = 1; i <= 10; i++)
        Soma = Soma + parseInt(n.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11))
        Resto = 0;
    if (Resto !== parseInt(n.substring(10, 11))) {
        alert("CPF Invalido!");
        limpa_formulário_cpf();
        return false;
    }
    return true;
}


function validarCNPJ(cnpj) {

    cnpj = cnpj.value;

    if(cnpj == ''){
        alert("CNPJ Invalido!");
        limpa_formulário_cnpj();
        return false;
    }

    if (cnpj.length != 14){
        alert("CNPJ Invalido!");
        limpa_formulário_cnpj();
        return false;
    }

    // LINHA 10 - Elimina CNPJs invalidos conhecidos
    if (cnpj == "00000000000000" || 
        cnpj == "11111111111111" || 
        cnpj == "22222222222222" || 
        cnpj == "33333333333333" || 
        cnpj == "44444444444444" || 
        cnpj == "55555555555555" || 
        cnpj == "66666666666666" || 
        cnpj == "77777777777777" || 
        cnpj == "88888888888888" || 
        cnpj == "99999999999999"){
        alert("CNPJ Invalido!");
        limpa_formulário_cnpj();
        return false; // LINHA 21
    }

    // Valida DVs LINHA 23 -
    tamanho = cnpj.length - 2
    numeros = cnpj.substring(0,tamanho);
    digitos = cnpj.substring(tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(0)){
        alert("CNPJ Invalido!");
        limpa_formulário_cnpj();
        return false;
    }

    tamanho = tamanho + 1;
    numeros = cnpj.substring(0,tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(1)){
        alert("CNPJ Invalido!");
        limpa_formulário_cnpj();
        return false;
    }  // LINHA 49

    return true; // LINHA 51

}
function calcular() {
    var num1 = Number(document.getElementById("Aluno").value);
    var num2 = Number(document.getElementById("num2").value);
    var elemResult = document.getElementById("resultado");

    if (elemResult.textContent === undefined) {
       elemResult.textContent = "O resultado é " + String(num1 + num2) + ".";
    }
    else { // IE
       elemResult.innerText = "O resultado é " + String(num1 + num2) + ".";
    }
    /* Mudar no html para funcionar a função
     * <input type="text" id="num1" onblur="calcular();" />
<input type="text" id="num2" onblur="calcular();" />
<span id="resultado"></span>
     */
}

function exportToExcel(tableID){
    var tab_text="<table border='2px'><tr bgcolor='#87AFC6' style='height: 75px; text-align: center; width: 250px'>";
    var textRange; var j=0;
    tab = document.getElementById(tableID); // id of table

    for(j = 0 ; j < tab.rows.length ; j++)
    {

        tab_text=tab_text;

        tab_text=tab_text+tab.rows[j].innerHTML.toUpperCase()+"</tr>";
        //tab_text=tab_text+"</tr>";
    }

    tab_text= tab_text+"</table>";
    tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, ""); //remove if u want links in your table
    tab_text= tab_text.replace(/<img[^>]*>/gi,""); //remove if u want images in your table
    tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); //remove input params
    tab_text= retira_acentos(tab_text);

    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE ");


    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer

    {
        txtArea1.document.open("txt/html","replace");
        txtArea1.document.write( 'sep=,\r\n' + tab_text);
        txtArea1.document.close();
        txtArea1.focus();
        sa=txtArea1.document.execCommand("SaveAs",true,"sudhir123.txt");
    }

    else {
       sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));
    }
    
    return (sa);
}

function retira_acentos(palavra) {
    com_acento = 'áàãâäéèêëíìîïóòõôöúùûüçÁÀÃÂÄÉÈÊËÍÌÎÏÓÒÕÖÔÚÙÛÜÇ';
    sem_acento = 'aaaaaeeeeiiiiooooouuuucAAAAAEEEEIIIIOOOOOUUUUC';
    nova='';
    for(i=0;i<palavra.length;i++) {
      if (com_acento.search(palavra.substr(i,1))>=0) {
      nova+=sem_acento.substr(com_acento.search(palavra.substr(i,1)),1);
      }
      else {
       nova+=palavra.substr(i,1);
      }
    }
    return nova;
}


function removerItemCarrinho() {

var node = document.getElementById(this);
if (node.parentNode) {
  node.parentNode.removeChild(node);
  
}
}
