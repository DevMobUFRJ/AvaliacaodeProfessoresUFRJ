Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  resources :aluno, param: :dre do
    resources :cursa, only: [:index, :create, :destroy], param: :disciplina_periodo_id
  end
  resources :disciplina, param: :codigo
  resources :docente, param: :matricula
  resources :disciplina_periodo
  resources :avaliacao
end
