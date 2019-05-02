<?php
    $url = "http://localhost:8080/contatos";
    $json = file_get_contents($url);
    $dados_array = json_decode($json, true);
    // print_r($json);
    // print_r($dados_array);
  //  echo phpinfo();

?>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <title>Page Title</title>
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <script src="main.js"></script>
    </head>
    <body>
        <header>
            <a href="cadastro.html">
                <h2>IR PARA O CADASTRO</h2>
            </a>
        </header>
        <h3>Lista de contato</h3>
        <table border="5" width="800px">    
            <tr>
                <td>   
                    Nome:
                </td>
                <td>
                    Telefone:
                </td>
                <td>
                    email:
                </td>
            </tr>
                <!-- corpo table -->
                <?php
                    foreach($dados_array as $key => $contato){
                        $nome =$contato["nome"];
                        $telefone = $contato["telefone"];
                        $email = $contato['email']; 
                        echo "
                        <tr>
                            <td>$nome</td>
                            <td>$telefone</td>
                            <td>$email</td>
                        </tr>
                        ";   
                    }
                ?>
            
        </table>
    </body>
</html> 