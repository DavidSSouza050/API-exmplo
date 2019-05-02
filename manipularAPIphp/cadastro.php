<?php
    $nome = $_POST['txt_nome'];
    $email = $_POST['txt_email'];
    $endereco = $_POST['txt_endereco'];
    $telefone = $_POST['txt_telefone'];
    $linkedin = $_POST['txt_linkedin'];
    $foto = $_POST['txt_foto'];

    // CRIAR ARRAY
    $contato_array = array(
        "nome"=>$nome,
        "endereco"=>$endereco,
        "telefone"=>$telefone,
        "email"=>$email,
        "linkedin"=>$linkedin,
        "foto"=>$foto
    );
    //CONVERTER ARRAY PARA JSON
    $contato_json = json_encode($contato_array);
    // DEFINIR A URL DA API QUE SERÁ UTILIZADA
    $url = "http://localhost:8080/contatos";

    // ABRIR A CONEXÃO PARA A API
    $con = curl_init($url);

    // DEFINIR O METODO DA RUQUISIÇÃO HTTP PARA POST
    curl_setopt($con, CURLOPT_CUSTOMREQUEST, "POST");

    //DEFINIR O CONTEÚDO DO BODY DA MENSAGEM
    curl_setopt($con, CURLOPT_POSTFIELDS, $contato_json);

    //DEFINIR SE ACEITAMOS RETORNO
    curl_setopt($con, CURLOPT_RETURNTRANSFER, true);

    // DEFINIR HEADER NECESSÁRIOS
    curl_setopt($con, CURLOPT_HTTPHEADER, 
        array('Content-Type: application/json',
        'Content-Length: ' . strlen($contato_json))
    );

  $jsonRetorno = j curl_exec($con);
?>
<h4>CADASTRO DE COISA LEGAL FEITO COM SUCELSO</h4>
<a href="index.php">voltar para a pagina pincipal</a>