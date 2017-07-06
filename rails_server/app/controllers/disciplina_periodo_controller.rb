class DisciplinaPeriodoController < ApplicationController
  before_action :set_disciplina_periodo, only: [:show, :update, :destroy]

  # GET /disciplina_periodo
  def index
    @disciplina_periodos = DisciplinaPeriodo.all
    json_response(@disciplina_periodos)
  end

  # POST /disciplina_periodo
  def create
    params[:docente_matricula].upcase!
    params[:disciplina_codigo].upcase!
    @disciplina_periodo = DisciplinaPeriodo.create!(disciplina_periodo_params)
    json_response(@disciplina_periodo, :created)
  end

  # GET /disciplina_periodo/:id
  def show
    json_response(@disciplina_periodo)
  end

  # PUT /disciplina_periodo/:id
  def update
    @disciplina_periodo.update(disciplina_periodo_params)
    head :no_content
  end

  # DELETE /disciplina_periodo/:id
  def destroy
    @disciplina_periodo.destroy
    head :no_content
  end

  private

  def disciplina_periodo_params
    params.permit(:docente_matricula, :disciplina_codigo, :periodo)
  end

  def set_disciplina_periodo
    @disciplina_periodo = DisciplinaPeriodo.find(params[:id])
  end
end
