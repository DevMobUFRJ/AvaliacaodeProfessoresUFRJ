class AlunoController < ApplicationController
  # chama o metodo set_aluno antes dos metodos especificados
  before_action :set_aluno, only: [:show, :update, :destroy]

  # GET /alunos
  def index
    @alunos = Aluno.all
    json_response(@alunos)
  end

  # POST /alunos
  def create
    @aluno = Aluno.create!(aluno_params)
    json_response(@aluno, :created)
  end

  # GET /alunos/:id
  def show
    json_response(@aluno)
  end

  # PUT /alunos/:id
  def update
    @aluno.update(aluno_params)
    head :no_content
  end

  # DELETE /alunos/:id
  def destroy
    @aluno.destroy
    head :no_content
  end

  private

  def aluno_params
    #Parametros aceitos
    params.permit(:dre, :nome)
  end

  def set_aluno
    @aluno = Aluno.find_by(dre: params[:dre])
  end
end
