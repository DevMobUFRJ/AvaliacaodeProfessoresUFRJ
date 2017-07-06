class CreateAlunos < ActiveRecord::Migration[5.1]
  def change
    create_table :alunos do |t|
      t.string :dre
      t.string :nome

      t.timestamps
    end
    add_index :alunos, :dre, unique: true
  end
end
