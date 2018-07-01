/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import conexao.JPA;
import controladores.entidades.UsersJpaController;
import entidades.SgEmprestimo;
import entidades.Users;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Manhique
 */
public class Acesso {

    public Acesso() {
    }
    
    
    
    public boolean isbloqueado(String nm){
        Users user = new UsersJpaController(new JPA().getEmf()).findUsers(nm);
        return (user.getEstado().equalsIgnoreCase("bloqueado"));     
    }
    
    public String bloquear(Users user) throws ParseException{
        try{
            List <SgEmprestimo> emprestimoList = user.getSgEmprestimoList();
            if(user.getEstado().equalsIgnoreCase("bloqueado")){
                return "o usuario ja foi bloqueado";
            }
            for(SgEmprestimo empst : emprestimoList){
                if(empst.getDataDevolucao().before(ConvertMilliSecondsToFormattedDate(System.currentTimeMillis()+""))){
                    if(empst.getMultaEstado().equalsIgnoreCase("NULL")){
                        user.setEstado("bloqueado");
                        return "utilizador bloqueado com sucesso";
                    }
                }
            }
        }catch(Exception e){
            return "o usuario nao fez nenhum emprestimo ate o momento";
        }
        return "situacao regularizada";
    }
    
    public String desbloquear(Users user){
        List <SgEmprestimo> emprestimoList = user.getSgEmprestimoList();
        if(user.getEstado().equalsIgnoreCase("bloqueado")){
            user.setEstado("Null");
            return "utilizador desbloqueado com sucesso";
        }
        return "o utilizador nao esta bloqueado";
    }
    
      public Date ConvertMilliSecondsToFormattedDate(String milliSeconds) throws ParseException{
        String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(milliSeconds));
        String dat= simpleDateFormat.format(calendar.getTime());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date date = new java.sql.Date(format.parse(dat).getTime());
        return date;
    }
    
    
}
