class DisciplinaController < ApplicationController
  before_action :set_disciplina, only: [:show, :update, :destroy]

  # GET /disciplina
  def index
    if params[:q]
      @query = params[:q].first
      @disciplinas = Disciplina.where('codigo = ? OR nome = ?', @query, @query)
    else
      @disciplinas = Disciplina.all
    end
    json_response(@disciplinas)
  end

  # POST /disciplina
  def create
    params[:codigo].upcase!
    @disciplina = Disciplina.create!(disciplina_params)
    json_response(@disciplina, :created)
  end

  # GET /disciplina/:codigo
  def show
    json_response(@disciplina)
  end

  # PUT /disciplina/:codigo
  def update
    @disciplina.update(disciplina_params)
    head :no_content
  end

  # DELETE /disciplina/:codigo
  def destroy
    @disciplina.destroy
    head :no_content
  end

  private

  def disciplina_params
    params.permit(:codigo, :nome)
  end

  def set_disciplina
    @disciplina = Disciplina.find_by(codigo: params[:codigo].upcase)
  end
end
