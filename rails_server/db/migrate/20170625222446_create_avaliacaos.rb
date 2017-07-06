class CreateAvaliacaos < ActiveRecord::Migration[5.1]
  def change
    create_table :avaliacaos do |t|
      t.string :aluno_dre
      t.integer :disciplina_periodo_id
      t.string :comentario
      t.boolean :status
      t.float :nota

      t.timestamps
    end
    add_index :avaliacaos, [:aluno_dre, :disciplina_periodo_id], unique: true
  end
end
