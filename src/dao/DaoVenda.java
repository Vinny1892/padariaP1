package dao;

import controller.ControllerCliente;
import controller.ControllerEstoque;
import controller.ControllerProduto;
import controller.ControllerVendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoVenda;
import model.GestaoEstoque;
import model.Vendedor;
import model.GestaoCliente;
import model.GestaoProduto;

public class DaoVenda extends GenericDao implements CRUDBasico {
    
    private static int ID_VENDA = 0;

    //id_venda devera se reptir para cada id_produto, ou seja, 5 produtos diferentes, id_venda repete 5 vezes.
    // a venda repete quando o produto muda
    //ou seja, para cada item comprado do carrinho, a venda deve repetir seu id
    //mundando o id_produto, e mantando o id_venda, até acabar o carrinho
    /*
    Metodo utilizado para salvar uma venda na tabela/entidade venda,
    com o objeto recebido como parametro.
     */
    @Override
    public void salvar(Object object) throws SQLException {//cada id_venda só pode repetir 20vezes
        GestaoVenda venda = (GestaoVenda) object;
        for (int i = 0; i < venda.getEstoques().size(); i++) {
            String insert = "INSERT INTO vendas (id_venda, data_venda, forma_pagamento, id_cliente, id_vendedor, id_estoque, valor_total_venda) VALUES(?,?,?,?,?,?,?) ";
            save(insert, ID_VENDA, venda.getDataVenda(), venda.getFormaPagamento(), venda.getCliente().getIdCliente(), venda.getVendedor().getIdVendedor(), venda.getEstoques().get(i).getIdEstoque(), venda.getValorTotalVenda());
        }
        JOptionPane.showMessageDialog(null, "Compra realizada");
        ID_VENDA++;
    }

    /*
    Metodo utilizado para editar uma venda na tabela/entidade venda,
    de acordo com objeto recebido.
     */
    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoVenda venda = (GestaoVenda) object;
        for (int i = 0; i < venda.getEstoques().size(); i++) {
            String update = "UPDATE produto SET data_venda = ?,forma_pagamento = ?, id_cliente = ?,id_vendedor = ?, id_estoque = ?, valor_total_venda = ? WHERE id_venda =  ? ";
            update(update, venda.getDataVenda(), venda.getVendedor().getIdVendedor(), venda.getCliente().getIdCliente(), venda.getCliente().getIdCliente(), venda.getFormaPagamento(), venda.getIdVenda(), venda.getEstoques().get(i).getIdEstoque(), venda.getValorTotalVenda());
        }
        System.out.println("Metodo atualizar DaoVenda realizado");
    }

    /*
    Metodo utilizado para deletar venda na tabela/entidade venda,
    de acordo com idVenda.
     */
    @Override
    public void deletar(String idVendaSt) throws SQLException {
        int idVenda = Integer.parseInt(idVendaSt);
        delete("DELETE FROM produto WHERE id_venda = ? ", idVenda);
    }

    //retorna um ArrayList do tipo Object
    //Array preenchido por objetos do tipo GestaoVenda
    //Aonde possui idVenda recebido como parametro igual ao id_venda do banco
    //e id_venda no banco pode se repetir, por isso retorna um Array
    @Override
    public ArrayList<Object> getById(int id) throws SQLException {
        ArrayList<Object> objetosVenda = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM venda WHERE id_venda = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Vendedor vendedor = (Vendedor) new ControllerVendedor().selecionaObjeto(rs.getInt("id_vendedor"));
            GestaoCliente cliente = (GestaoCliente) new ControllerCliente().selecionaObjeto(rs.getInt("id_cliente"));
            ArrayList<GestaoEstoque> estoqueId = (ArrayList<GestaoEstoque>) (ArrayList<?>) new DaoEstoque().getById(rs.getInt("id_estoque"));
            GestaoVenda venda = new GestaoVenda(rs.getString("data_venda"), vendedor, cliente, estoqueId, rs.getInt("forma_pagamento"), id, rs.getFloat("valor_total_venda"));
            objetosVenda.add(venda);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getById() DaoEstoque realizado");
        return objetosVenda;
    }

    /*
    Metodo utilizado para pegar todas as vendas da tabela/entidade venda,
    retornando um ArrayList de objeto do tipo GestaoVenda
     */
    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> vendas = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM venda");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Vendedor vendedor = (Vendedor) new ControllerVendedor().selecionaObjeto(rs.getInt("id_vendedor"));
            GestaoCliente cliente = (GestaoCliente) new ControllerCliente().selecionaObjeto(rs.getInt("id_cliente"));
            ArrayList<GestaoEstoque> idEstoqueVendidos = (ArrayList<GestaoEstoque>) (ArrayList<?>) new DaoVenda().getById(rs.getInt("id_venda"));
            GestaoVenda venda = new GestaoVenda(rs.getString("data_venda"), vendedor, cliente, idEstoqueVendidos, rs.getInt("forma_pagamento"), rs.getInt("id_venda"), rs.getFloat("valor_total_venda"));
            vendas.add(venda);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getAll() GestaoVenda realizado");
        return vendas;
    }

}
