import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class ServidorTest{
	public static void main(String args[]){
		int puerto = 5000;
		try{
			System.out.println("Iniciando servidor.....: [" + puerto + "]");

			ServerSocket servidor = new ServerSocket(puerto);
			Socket cliente = servidor.accept();

			System.out.println("Cliente conectado....");
			InputStream is = cliente.getInputStream();			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader in = new BufferedReader(isr);
			
			String texto_cliente = in.readLine();
			//Segunda l�nea
			texto_cliente += "\n" + in.readLine();
			//Tercera l�nea
			texto_cliente += "\n" + in.readLine();
			//Cuarta l�nea
			texto_cliente += "\n" + in.readLine();
			
			System.out.println("Mensaje enviado por el cliente: \n" + texto_cliente);

			OutputStream os = cliente.getOutputStream();			
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter out = new PrintWriter(bw);

			String respuesta = "HTTP/1.1 200 OK \n"
				+ "Content-Type: text/html \n"
				+ "Content-Length: 163\n"
				+ "\n"
				+ "<HTML>"
				+ "<TITLE>P�gina de Flujos de E y S </TITLE>"
				+ "<MARQUEE><H1>Hola</H1></MARQUEE><SCRIPT type='text/javascript'>alert(\"Hola clase de programaci�n\");</SCRIPT>"
				+ "</HTML>\n\n";		

			out.println(respuesta);
			out.flush();
			cliente.close();
		}catch(IOException e){
			System.out.println("El servidor no pude ser iniciado en el puerto: " + puerto);
		}		

	}
}