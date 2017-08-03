class CreateDocentes < ActiveRecord::Migration[5.1]
  def change
    create_table :docentes do |t|
      t.string :matricula
      t.string :nome

      t.timestamps
    end
    add_index :docentes, :matricula, unique: true
  end
end
