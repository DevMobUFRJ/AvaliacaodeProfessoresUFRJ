class CreateDisciplinaPeriodos < ActiveRecord::Migration[5.1]
  def change
    create_table :disciplina_periodos do |t|
      #TODO Referencia de chave estrangeira
      t.string :docente_matricula
      t.string :disciplina_codigo
      t.string :periodo, limit: 6, null: false

      t.timestamps
    end
    add_index :disciplina_periodos, [:docente_matricula, :disciplina_codigo, :periodo], name: :index_disciplina_periodos_all, unique: true
  end
end
