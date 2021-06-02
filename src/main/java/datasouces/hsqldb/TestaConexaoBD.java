package datasouces.hsqldb;

import java.sql.Connection;

import datasouces.hsqldb.config.ConexaoBD;

public class TestaConexaoBD {

    public static void main(String[] args) {
        ConexaoBD connectionConfig = new ConexaoBD();
        try (Connection c = connectionConfig.getConnection()) {
            System.out.println("Conexão com banco de Dados sucesso!!!");
            BuildDeTabelas buildTabelas = new BuildDeTabelas();
            buildTabelas.construirTabelas();
            buildTabelas.inserirDados();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Conexão com banco fechada!!!");
    }

}
