/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelCuci;
import util.Koneksi;

/**
 *
 * @author user
 */
public class Controllercuci {
     Koneksi koneksi = new Koneksi();

    public void simpanCucian(ModelCuci mc) {
        koneksi.koneksiDatabase();
        String querySimpanCucian = "insert into tb_cucian (KodeCucian,NamaPemilik, Jenis_Cucian, BeratCucian,"
                + "JumlahBayar, Tanggaldatang, TanggalAmbil, NomerTelp)"
                + " values('" + mc.getKode() + "','" + mc.getNamapemilik() + "','"
                + mc.getJeniscucian()+"','"+mc.getBeratcucian()+"','"+mc.getTotalbayar()+"','"+mc.getTanggalmasuk()+"','"
                +mc.getTanggalambil()+"','"+mc.getNomortelp()+"')";
        
        try {
            koneksi.state.executeUpdate(querySimpanCucian);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
            System.err.println("Galat Controller Teman : " + e);
        }
    }
    public void hapusCucian(ModelCuci mc){
        try {
            koneksi.koneksiDatabase();
            String queryHapusDataTeman = "delete from tb_cucian where id=('"+mc.getKode()+"')";
            koneksi.state.executeUpdate(queryHapusDataTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Galat hapusDataTeman : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
    
}
