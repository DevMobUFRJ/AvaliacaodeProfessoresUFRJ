class CursaController < ApplicationController
  #TODO Concluir metodos e deixar remover
  before_action :set_cursa, only: [:destroy]

  # GET /aluno/:aluno_dre/cursa
  def index
    #TODO Receber parametro ?avaliado=0 para filtrar as que ainda faltam ser avaliadas
    @cursa = Cursa.where(aluno_dre: params[:aluno_dre]).all
    json_response(@cursa)
  end

  # POST /alunos/:aluno_dre/cursa
  def create
    @cursa = Cursa.create!(cursa_params)
    json_response(@cursa, :created)
  end

  # DELETE /alunos/:aluno_dre/cursa/:disciplina_periodo_id
  def destroy
    if @cursa != nil
      @cursa.destroy
    end
    head :no_content
  end

  private

  def cursa_params
    params.permit(:aluno_dre, :disciplina_periodo_id)
  end

  def set_cursa
    @cursa = Cursa.find_by(aluno_dre: params[:aluno_dre], disciplina_periodo_id: params[:disciplina_periodo_id])
  end

end
