<h2>Devoir 4 CSI 3540 </h2>
Ce repertoire contient les fichiers du devoir 4 du cours de csi 3540. Il s'agit d'un systeme de waiting list d'hopital. Le projet est partagé en deux parties.
Le frontend ainsi que le backend.

<h3>Backend</h3>
Le backend a été developpé en utilisant le framework java de springboot. Il est connecté a une base de données postgres. Pour executer le backend, il faut ajouter
les variables d'environements telles que specifié dans la partie "comment executer". Assurer vous aussi d'avoir postgres ainsi que java installé avant d'executer 
le backend.

<h3>Frontend</h3>
Le frontend de ce devoir a été implementé en executant le framework Angular. Assurez vous d'avoir Nodejs installé sur votre macchine avant de lancer le frontend.
<b>Pour avoir accès aux fonctionnalités d'administrateur de l'application, il faut se connecter avec le mot de passe "admin".</b> Les fonctionnalités de l'administrateur
sont ajouter et enlever des tickets de patients, il a en plus accès aux données supplementaire des patients. Les fonctionnalités d'utilisateur est de voir la liste 
de patients.

<h3>Comment executer</h3>

Prerequis :
<ul>
<li>Avoir java installé.</li>
<li>Avoir Postgres installé</li>
<li>Avoir Nodejs installé</li>
</ul>

Étapes d'execution :
<ol>
<li>Ajouter les variable d'environement (username, password, url) au projet springboot afin que l'application puisse se connecter au base de données. Le procedure à suivre peut etre different
dependament de l'IDE utilisé (IntelliJ est celui utilisé au developpement). Si cela est difficile, inclure ces variable directement dans "application.properties". </li>
<li>Lancer l'application du backend</li>
<li>Ouvrir cmd dans le folder du frontend</li>
<li>Executer "npm install" afin d'installer les dependances nécessaire</li>
<li>Lancer l'application avec la commande "ng serve" </li>
<li>Le mot de passe pour acceder aux fonctionalité de l'administrateur est "admin"</li>
</ol>
