class CreateCursas < ActiveRecord::Migration[5.1]
  def change
    create_table :cursas do |t|
      t.string :aluno_dre
      t.integer :disciplina_periodo_id

      t.timestamps
    end
    add_index :cursas, [:aluno_dre, :disciplina_periodo_id], unique: true
  end
end
