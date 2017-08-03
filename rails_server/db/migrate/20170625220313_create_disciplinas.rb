class CreateDisciplinas < ActiveRecord::Migration[5.1]
  def change
    create_table :disciplinas do |t|
      t.string :codigo
      t.string :nome

      t.timestamps
    end
    add_index :disciplinas, :codigo, unique: true
  end
end
