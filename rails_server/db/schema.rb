# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20170625222446) do

  create_table "alunos", force: :cascade do |t|
    t.string "dre"
    t.string "nome"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["dre"], name: "index_alunos_on_dre", unique: true
  end

  create_table "avaliacaos", force: :cascade do |t|
    t.string "aluno_dre"
    t.integer "disciplina_periodo_id"
    t.string "comentario"
    t.boolean "status"
    t.float "nota"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["aluno_dre", "disciplina_periodo_id"], name: "index_avaliacaos_on_aluno_dre_and_disciplina_periodo_id", unique: true
  end

  create_table "cursas", force: :cascade do |t|
    t.string "aluno_dre"
    t.integer "disciplina_periodo_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["aluno_dre", "disciplina_periodo_id"], name: "index_cursas_on_aluno_dre_and_disciplina_periodo_id", unique: true
  end

  create_table "disciplina_periodos", force: :cascade do |t|
    t.string "docente_matricula"
    t.string "disciplina_codigo"
    t.string "periodo", limit: 6, null: false
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["docente_matricula", "disciplina_codigo", "periodo"], name: "index_disciplina_periodos_all", unique: true
  end

  create_table "disciplinas", force: :cascade do |t|
    t.string "codigo"
    t.string "nome"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["codigo"], name: "index_disciplinas_on_codigo", unique: true
  end

  create_table "docentes", force: :cascade do |t|
    t.string "matricula"
    t.string "nome"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["matricula"], name: "index_docentes_on_matricula", unique: true
  end

end
