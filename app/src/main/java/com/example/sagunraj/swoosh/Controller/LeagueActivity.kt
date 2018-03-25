package com.example.sagunraj.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.example.sagunraj.swoosh.Model.Player
import com.example.sagunraj.swoosh.R
import com.example.sagunraj.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle?) { //to save the instance data
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player) //can be put at putExtra if no Parcelable is used
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) { //what activity is recreated
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null) { //if we have an instance state saved
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun leagueNextClicked(view: View){
        if(player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        }
        else{
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMensClicked(view: View){
        if(player.league == "mens"){
            player.league = ""
        }
        else {
            womensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            player.league = "mens"
        }
    }

    fun onWomensClicked(view: View){
        if(player.league == "womens"){
            player.league = ""
        }
        else {
            mensLeagueBtn.isChecked = false
            coedLeagueBtn.isChecked = false
            player.league = "womens"
        }
    }

    fun onCoedClicked(view: View){
        if(player.league == "mens"){
            player.league = ""
        }
        else {
            mensLeagueBtn.isChecked = false
            womensLeagueBtn.isChecked = false
            player.league = "co-ed"
        }
    }

}
