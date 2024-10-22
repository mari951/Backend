package controller;
import view.*;
import java.swing.*;

public class TelaDeMenuController extends TelaDeMenuView {
public static void abrirTelaDeCadastroView() {
TelaDeCadastroView.appTelaDeCadastroView = new TelaDeCadastroView();
TelaDeCadastroView.appTelaDeCadastroView.setDefaultCloseOperation(DiSPOSE_ON_CLOSE);

appTelaDeMenuView.setVisible( false);


TelaDeCadastroView.appTelaDeCadastroView.addWindowListener(
new WindowAdaPter(){
public void windowClosing(WindowEvent e) {
appTelaDeMenuView.setVisible()

 }
    
}

   public class TelaDeMenuPesquisa {
    public static void abrirTelaDePesquisaView() {
    TelaDePesquisaView.appTelaDePesquisaView = new TelaDePesquisaView();
    TelaDePesquisaView.appTelaDePesquisaView.setDefaultCloseOperation(DiSPOSE_ON_CLOSE);
    
    appTelaDeMenuView.setVisible( false);
    
    
    TelaDePesquisaView.appTelaDePesquisaView.addWindowListener(
    new WindowAdaPter(){
    public void windowClosing(WindowEvent e) {
    appTelaDeMenuView.setVisible()


    public class TelaDeMenuAtualizar {
        public static void abrirTelaDeAtualizarView() {
        TelaDeAtualizarView.appTelaDeAtualizarView = new TelaDePesquisaView();
        TelaDeAtualizarView.appTelaAtualizarView.setDefaultCloseOperation(DiSPOSE_ON_CLOSE);
        
        appTelaDeMenuView.setVisible( false);
        
        
        TelaDeAtualizarView.appTelaDeAtualizarView.addWindowListener(
        new WindowAdaPter(){
        public void windowClosing(WindowEvent e) {
        appTelaDeMenuView.setVisible()

        public class TelaDeRemoverView {
            public static void abrirTelaDeRemoverView() {
            TelaDeRemoverView.appTelaDeRemoverView = new TelaDeRemoverView();
            TelaDeRemoverView.appTelaDeRemoverView.setDefaultCloseOperation(DiSPOSE_ON_CLOSE);
            
            appTelaDeMenuView.setVisible( false);
            
            
            TelaDeRemoverView.appTelaDeRemoverView.addWindowListener(
            new WindowAdaPter(){
            public void windowClosing(WindowEvent e) {
            appTelaDeMenuView.setVisible()
            
        
    