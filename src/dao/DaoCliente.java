package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import controller.ControllerCartao;
import java.sql.SQLException;
import java.util.List;
import model.GestaoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.CartaoFidelidade;

public class DaoCliente extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            GestaoCliente cliente = (GestaoCliente) object;
            String insert = "INSERT INTO cliente (nome,endereco,cpf,telefone,idcartao_fidelidade) VALUES(?,?,?,?) ";
            //CartaoFidelidade cartao = (CartaoFidelidade) new ControllerCartao().selecionaObjeto(rs.getInt("id_cartao"));
            save(insert, cliente.getNome(), cliente.getEndereco(), cliente.getCpf(), cliente.getTelefone(), cliente.getCartaoFidelidade().getIdcartaoFidelidade());
            System.out.println("Metodo salvar DaoCliente realizado");
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CPF Ja existe");
            JOptionPane.showMessageDialog(null, "CPF ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
        }
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoCliente cliente = (GestaoCliente) object;
        String update = "UPDATE cliente SET nome = ?,endereco = ?,telefone = ? WHERE cpf =  ? ";
        update(update, cliente.getCpf(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone());
        System.out.println("Metodo atualizar DaoCliente realizado");
    }

    @Override
    public void deletar(String cpf) throws SQLException {
        delete("DELETE FROM cliente WHERE cpf = ? ", cpf);
        System.out.println("Metodo deletar() DaoCliente realizado");
    }

    @Override
    public List<Object> getById(int id) throws SQLException {
        ArrayList<Object> clientes = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM cliente WHERE id_cliente = " + id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            CartaoFidelidade cartao = (CartaoFidelidade) new ControllerCartao().selecionaObjeto(rs.getInt("id_cartao"));
            GestaoCliente cliente = new GestaoCliente(rs.getString("nome"), rs.getString("endereco"), rs.getString("cpf"), rs.getString("telefone"), cartao, id);
            clientes.add(cliente);
        }
        rs.close();
        stmt.close();
        return clientes;
    }

    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> clientes = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM cliente");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            CartaoFidelidade cartao = (CartaoFidelidade) new ControllerCartao().selecionaObjeto(rs.getInt("id_cartao"));
            GestaoCliente cliente = new GestaoCliente(rs.getString("nome"), rs.getString("endereco"), rs.getString("cpf"), rs.getString("telefone"), cartao, rs.getInt("id_cartao"));
            clientes.add(cliente);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getAll() DaoCliente realizado");
        return clientes;
    }

}
