class DocenteController < ApplicationController
  before_action :set_docente, only: [:show, :update, :destroy]

  # GET /docente
  def index
    @docentes = Docente.all
    json_response(@docentes)
  end

  # POST /docente
  def create
    params[:matricula].upcase!
    @docente = Docente.create!(docente_params)
    json_response(@docente, :created)
  end

  # GET /docente/:matricula
  def show
    json_response(@docente)
  end

  # PUT /docente/:matricula
  def update
    @docente.update(docente_params)
    head :no_content
  end

  # DELETE /docente/:matricula
  def destroy
    @docente.destroy
    head :no_content
  end

  private

  def docente_params
    params.permit(:matricula, :nome)
  end

  def set_docente
    @docente = Docente.find_by(matricula: params[:matricula].upcase)
  end
end
