package br.com.fiap.socket;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.fiap.bean.Aluno;

public class Server {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(1234);
		while(true) {
		System.out.println("Aguardando conexao...");
		Socket socket = server.accept();
		
		ObjectInputStream objectStream = new ObjectInputStream(socket.getInputStream());
		Aluno aluno = (Aluno) objectStream.readObject();
		
		System.out.println(aluno.getNome() + "\n" + aluno.getRm());
		}
		//objectStream.close();
		//socket.close();
		//server.close();
	}

}
