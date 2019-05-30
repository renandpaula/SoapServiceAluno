package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import domain.Aluno;
import domain.Materia;

public class ClienteJava {
	 
    private static int HTTP_COD_SUCESSO = 200;
 
    public static void main(String[] args) throws JAXBException {
 
        try {
 
            URL url = new URL("http://localhost:8080/alunosRestService/materia/get");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
 
            if (con.getResponseCode() != HTTP_COD_SUCESSO) {
                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
            }
 
            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
                         
            JAXBContext jaxbContext = JAXBContext.newInstance(Materia.class);
 
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Materia materia = (Materia) jaxbUnmarshaller.unmarshal(br);
             
            System.out.println("------  Dados da Materia  -------- \n");
            System.out.println("Nome da Materia : "+materia.getNome());
            System.out.println("Nome da Turma : "+materia.getTurma().getNome());
            System.out.println("Sala da Turma: "+materia.getTurma().getSala());
             
            int count = 1;
             
            for (Aluno aluno : materia.getTurma().getAlunos()) {
                System.out.println("Aluno "+ count +": "+ aluno.getNome());
                count++;    
            }
 
            con.disconnect();
 
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}