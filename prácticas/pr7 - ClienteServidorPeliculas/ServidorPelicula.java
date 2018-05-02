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
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


public class ServidorPelicula{

	public void guardar(String na, Pelicula p) throws FileNotFoundException, NombreArchivoInvalidoException{
		if ( na != null && !na.equals("")){
			File f = new File(na);
			FileOutputStream fos = new FileOutputStream(f, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter out = new PrintWriter(bw);
			out.println(p.toString());
			out.close();
		}else{
			throw new NombreArchivoInvalidoException();
		}
	}
	
	public void iniciar(int puerto) throws InterruptedException, IOException{
		while(true){
			System.out.println("Iniciando servidor.....");
			ServerSocket servidor = new ServerSocket(puerto);
			Socket cliente = servidor.accept();

			System.out.println("Cliente conectado....");

			//Creando objetos para lectura
			InputStream is = cliente.getInputStream();			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader in = new BufferedReader(isr);
			
			//Creando objetos para escritura
			OutputStream os = cliente.getOutputStream();			
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter out = new PrintWriter(bw);

			out.println("Env�ame un t�tulo de la pel�cula: ");
			out.flush();
			String ttitulo = in.readLine();
			System.out.println("Recibiendo t�tulo de pel�cula: " + ttitulo);

			out.println("Env�ame director de la pel�cula: ");
			out.flush();
			String tdirector = in.readLine();
			System.out.println("Recibiendo director de pel�cula: " + tdirector);

			out.println("Env�ame a�o de pel�cula: ");
			out.flush();
			String tanio = in.readLine();
			System.out.println("Recibiendo a�o de pel�cula: " + tanio);

			Pelicula p = new Pelicula(ttitulo, tdirector, tanio);
			try{
				guardar("peliculas.txt", p);		
				System.out.println("Pel�cula almacenada");
			}catch(NombreArchivoInvalidoException e){
			}catch(FileNotFoundException e){
			}
			out.close();
			in.close();
			cliente.close();
			System.out.println("Cliente desconectado...");
			servidor.close();
			System.out.println("Reiniciando servidor...");
			Thread.sleep(3000); //Esperar 3 segundos
		}
	}

	public static void main(String args[]) throws InterruptedException{
		try{
			int puerto = Integer.parseInt(args[0]);
			ServidorPelicula sp = new ServidorPelicula();
			sp.iniciar(puerto);
		}catch(IOException e){
			System.out.println("El servidor no pudo iniciar....");
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Par�metros inv�lidos: java ServidorPelicula <puerto>");
		}
	}
	

}