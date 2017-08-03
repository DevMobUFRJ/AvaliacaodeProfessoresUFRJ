class AvaliacaoController < ApplicationController
  #TODO Tudo praticamente.
  # chama o metodo set_avaliacao antes dos metodos especificados
  before_action :set_avaliacao, only: [:show, :update, :destroy]

  # GET /avaliacao
  def index
    @avals = Avaliacao.all
    json_response(@avals)
  end

  # POST /avaliacao
  def create
    @avaliacao = Avaliacao.create!(avaliacao_params)
  end

  # GET /avaliacao/:id
  def show
    json_response(@avaliacao)
  end

  # PUT /avaliacao/:id
  def update
    @avaliacao.update(avaliacao_params)
    head :no_content
  end

  # DELETE /avaliacao/:id
  def destroy
    @avaliacao.destroy
    head :no_content
  end

  private

  def avaliacao_params
    params.permit(:aluno_dre, :disciplina_periodo_id, :comentario, :status, :nota)
  end

  def set_avaliacao
    @avaliacao = Avaliacao.find(params[:id])
  end
end
