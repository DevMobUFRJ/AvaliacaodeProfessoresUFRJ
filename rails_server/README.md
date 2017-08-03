# README

This README would normally document whatever steps are necessary to get the
application up and running.

## Rotas
<table id="route_table" class="route_table">
  <thead>
    <tr>
      <th>Helper</th>
      <th>HTTP Verb</th>
      <th>Path</th>
      <th>Controller#Action</th>
    </tr>
    <tr class="bottom">
      <th>        <a data-route-helper="_path" title="Returns a relative path (without the http or domain)" href="#">Path</a> /
        <a data-route-helper="_url" title="Returns an absolute url (with the http and domain)" href="#">Url</a>
      </th>
      <th>      </th>
      <th>        <input id="search" placeholder="Path Match" name="path[]" type="search">
      </th>
      <th>      </th>
    </tr>
  </thead>
  <tbody class="exact_matches" id="exact_matches">
  </tbody>
  <tbody class="fuzzy_matches" id="fuzzy_matches">
  </tbody>
  <tbody>
    <tr class="route_row" data-helper="path">
  <td data-route-name="aluno_cursa_index">
      aluno_cursa_index<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/aluno/:aluno_dre/cursa(.:format)">
    /aluno/:aluno_dre/cursa(.:format)
  </td>
  <td>
    <p>cursa#index</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    POST
  </td>
  <td data-route-path="/aluno/:aluno_dre/cursa(.:format)">
    /aluno/:aluno_dre/cursa(.:format)
  </td>
  <td>
    <p>cursa#create</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="aluno_cursa">
      aluno_cursa<span class="helper">_path</span>
  </td>
  <td>
    DELETE
  </td>
  <td data-route-path="/aluno/:aluno_dre/cursa/:disciplina_periodo_id(.:format)">
    /aluno/:aluno_dre/cursa/:disciplina_periodo_id(.:format)
  </td>
  <td>
    <p>cursa#destroy</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="aluno_index">
      aluno_index<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/aluno(.:format)">
    /aluno(.:format)
  </td>
  <td>
    <p>aluno#index</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    POST
  </td>
  <td data-route-path="/aluno(.:format)">
    /aluno(.:format)
  </td>
  <td>
    <p>aluno#create</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="aluno">
      aluno<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/aluno/:dre(.:format)">
    /aluno/:dre(.:format)
  </td>
  <td>
    <p>aluno#show</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PATCH
  </td>
  <td data-route-path="/aluno/:dre(.:format)">
    /aluno/:dre(.:format)
  </td>
  <td>
    <p>aluno#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PUT
  </td>
  <td data-route-path="/aluno/:dre(.:format)">
    /aluno/:dre(.:format)
  </td>
  <td>
    <p>aluno#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    DELETE
  </td>
  <td data-route-path="/aluno/:dre(.:format)">
    /aluno/:dre(.:format)
  </td>
  <td>
    <p>aluno#destroy</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="disciplina_index">
      disciplina_index<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/disciplina(.:format)">
    /disciplina(.:format)
  </td>
  <td>
    <p>disciplina#index</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    POST
  </td>
  <td data-route-path="/disciplina(.:format)">
    /disciplina(.:format)
  </td>
  <td>
    <p>disciplina#create</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="disciplina">
      disciplina<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/disciplina/:codigo(.:format)">
    /disciplina/:codigo(.:format)
  </td>
  <td>
    <p>disciplina#show</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PATCH
  </td>
  <td data-route-path="/disciplina/:codigo(.:format)">
    /disciplina/:codigo(.:format)
  </td>
  <td>
    <p>disciplina#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PUT
  </td>
  <td data-route-path="/disciplina/:codigo(.:format)">
    /disciplina/:codigo(.:format)
  </td>
  <td>
    <p>disciplina#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    DELETE
  </td>
  <td data-route-path="/disciplina/:codigo(.:format)">
    /disciplina/:codigo(.:format)
  </td>
  <td>
    <p>disciplina#destroy</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="docente_index">
      docente_index<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/docente(.:format)">
    /docente(.:format)
  </td>
  <td>
    <p>docente#index</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    POST
  </td>
  <td data-route-path="/docente(.:format)">
    /docente(.:format)
  </td>
  <td>
    <p>docente#create</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="docente">
      docente<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/docente/:matricula(.:format)">
    /docente/:matricula(.:format)
  </td>
  <td>
    <p>docente#show</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PATCH
  </td>
  <td data-route-path="/docente/:matricula(.:format)">
    /docente/:matricula(.:format)
  </td>
  <td>
    <p>docente#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PUT
  </td>
  <td data-route-path="/docente/:matricula(.:format)">
    /docente/:matricula(.:format)
  </td>
  <td>
    <p>docente#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    DELETE
  </td>
  <td data-route-path="/docente/:matricula(.:format)">
    /docente/:matricula(.:format)
  </td>
  <td>
    <p>docente#destroy</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="disciplina_periodo_index">
      disciplina_periodo_index<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/disciplina_periodo(.:format)">
    /disciplina_periodo(.:format)
  </td>
  <td>
    <p>disciplina_periodo#index</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    POST
  </td>
  <td data-route-path="/disciplina_periodo(.:format)">
    /disciplina_periodo(.:format)
  </td>
  <td>
    <p>disciplina_periodo#create</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="disciplina_periodo">
      disciplina_periodo<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/disciplina_periodo/:id(.:format)">
    /disciplina_periodo/:id(.:format)
  </td>
  <td>
    <p>disciplina_periodo#show</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PATCH
  </td>
  <td data-route-path="/disciplina_periodo/:id(.:format)">
    /disciplina_periodo/:id(.:format)
  </td>
  <td>
    <p>disciplina_periodo#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PUT
  </td>
  <td data-route-path="/disciplina_periodo/:id(.:format)">
    /disciplina_periodo/:id(.:format)
  </td>
  <td>
    <p>disciplina_periodo#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    DELETE
  </td>
  <td data-route-path="/disciplina_periodo/:id(.:format)">
    /disciplina_periodo/:id(.:format)
  </td>
  <td>
    <p>disciplina_periodo#destroy</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="avaliacao_index">
      avaliacao_index<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/avaliacao(.:format)">
    /avaliacao(.:format)
  </td>
  <td>
    <p>avaliacao#index</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    POST
  </td>
  <td data-route-path="/avaliacao(.:format)">
    /avaliacao(.:format)
  </td>
  <td>
    <p>avaliacao#create</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="avaliacao">
      avaliacao<span class="helper">_path</span>
  </td>
  <td>
    GET
  </td>
  <td data-route-path="/avaliacao/:id(.:format)">
    /avaliacao/:id(.:format)
  </td>
  <td>
    <p>avaliacao#show</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PATCH
  </td>
  <td data-route-path="/avaliacao/:id(.:format)">
    /avaliacao/:id(.:format)
  </td>
  <td>
    <p>avaliacao#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    PUT
  </td>
  <td data-route-path="/avaliacao/:id(.:format)">
    /avaliacao/:id(.:format)
  </td>
  <td>
    <p>avaliacao#update</p>
  </td>
</tr>
<tr class="route_row" data-helper="path">
  <td data-route-name="">
  </td>
  <td>
    DELETE
  </td>
  <td data-route-path="/avaliacao/:id(.:format)">
    /avaliacao/:id(.:format)
  </td>
  <td>
    <p>avaliacao#destroy</p>
  </td>
</tr>

  </tbody>
</table>

Things you may want to cover:

* Ruby version

* System dependencies

* Configuration

* Database creation

* Database initialization

* How to run the test suite

* Services (job queues, cache servers, search engines, etc.)

* Deployment instructions

* ...
