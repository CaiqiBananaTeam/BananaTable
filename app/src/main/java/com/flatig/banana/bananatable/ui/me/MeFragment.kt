package com.flatig.banana.bananatable.ui.me

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.flatig.banana.bananatable.R
import com.flatig.banana.bananatable.TableApplication
import com.flatig.banana.bananatable.logic.model.MeFragRecyclerViewData
import com.flatig.banana.bananatable.logic.model.MoreFragCardViewData
import com.flatig.banana.bananatable.ui.more.MoreRecyclerAdapter

class MeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var itemShow = mutableListOf(
        MeFragRecyclerViewData(
            TableApplication.context.resources.getString(R.string.meItem_config),
            R.drawable.ic_baseline_scanner_24
        ),
        MeFragRecyclerViewData(
            TableApplication.context.resources.getString(R.string.meItem_change),
            R.drawable.ic_baseline_supervised_user_circle_24
        ),
        MeFragRecyclerViewData(
            TableApplication.context.resources.getString(R.string.meItem_set),
            R.drawable.ic_baseline_settings_applications_24
        )
    )
    private val itemList = ArrayList<MeFragRecyclerViewData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_me, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList(view)

        val layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.layoutManager = layoutManager
        val adapter = MeRecyclerAdapter(requireActivity(), itemList)
        recyclerView.adapter = adapter
    }

    private fun initList(view: View) {
        recyclerView = view.findViewById(R.id.meFrag_recyclerView)
        itemList.clear()

        for (i in (0 until itemShow.size)) itemList.add(itemShow[i])
    }
}