package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

import java.io.IOException;
import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.Disciplina;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.Disciplina.DisciplinaController;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.avaliacao.Avaliacao;
import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.avaliacao.AvaliacaoController;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by devmob on 19/04/17.
 */

public class teste {

    public static void main(String[] args){

//        Avaliacao av = new Avaliacao("1150362", "1253", "Didatica incrivel", 5, new int[]{1, 1, 0, -1, 0});
//        try {
//            Response<Avaliacao> r = AvaliacaoController.salvarAvaliacao(av);
//
//            System.out.println("Code: " + r.code());
//         //   System.out.println("Body: " + r.body().toString());
//            System.out.println("Msg: " + r.message());
//            System.out.println("toStr: " + r.toString());
//            System.out.println("Head: " + r.headers());
//            System.out.println("Raw: " + r.raw());
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        try {
//            List<Disciplina> r = DisciplinaController.listarDisciplinas();
//
//            for(Disciplina d : r){
//                System.out.println(d.getcodigo() + " | " + d.getNome());
//            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
