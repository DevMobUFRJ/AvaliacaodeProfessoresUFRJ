package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

/**
 * Created by George Rappel on 24/04/17
 */

public class Utils {

    /**
     * Tags em ordem que são registradas no array no servidor.
     *
     */
    public enum tag_docente {
        DIDATICA("Didática", 0), MATERIAL("Material", 1), ASSIDUIDADE("Assiduidade", 2),
        COBRA_PRESENCA("Cobra Presença", 3), OUTROCONCEITO("Conceito", 4);

        private String nome;
        private int value;

        tag_docente(String nome, int value) {
            this.nome = nome;
            this.value = value;
        }

        public String getNome(){ return this.nome; }

        /**
         *
         * @return Posição de ordenação da Tag
         */
        public int getValue(){ return this.value; }

    }

    public static final int tags_count = 5;


}
