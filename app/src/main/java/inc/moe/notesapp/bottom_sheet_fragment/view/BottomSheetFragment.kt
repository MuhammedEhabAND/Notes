package inc.moe.notesapp.bottom_sheet_fragment.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import inc.moe.notesapp.R

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var fNote1 : FrameLayout
    private lateinit var fNote2 : FrameLayout
    private lateinit var fNote3 : FrameLayout
    private lateinit var fNote4 : FrameLayout
    private lateinit var fNote5 : FrameLayout
    private lateinit var fNote6 : FrameLayout
    private lateinit var fNote7 : FrameLayout
    private lateinit var fNote8 : FrameLayout
    private lateinit var fNote9 : FrameLayout
    private lateinit var imgNote1:ImageView
    private lateinit var imgNote2:ImageView
    private lateinit var imgNote3:ImageView
    private lateinit var imgNote4:ImageView
    private lateinit var imgNote5:ImageView
    private lateinit var imgNote6:ImageView
    private lateinit var imgNote7:ImageView
    private lateinit var imgNote8:ImageView
    private lateinit var imgNote9:ImageView

    private var selectedColor ="#171C26"
    companion object{
        fun newInstance():BottomSheetFragment{
            val args =Bundle()
            val fragment= BottomSheetFragment()
            fragment.arguments=args
            return fragment
        }
    }
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_bottom_sheet , null)
        dialog.setContentView(view)
        val param = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = param.behavior
        if(behavior is BottomSheetBehavior<*>){
            behavior.setBottomSheetCallback(object :BottomSheetBehavior.BottomSheetCallback(){
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    var state = ""
                    when(newState){
                        BottomSheetBehavior.STATE_DRAGGING->{
                            state = "DRAGGING"
                        }
                        BottomSheetBehavior.STATE_SETTLING->{
                            state = "SETTLING"
                        }
                        BottomSheetBehavior.STATE_EXPANDED->{
                            state = "EXPANDED"
                        }
                        BottomSheetBehavior.STATE_COLLAPSED->{
                            state = "COLLAPSED"
                        }
                        BottomSheetBehavior.STATE_HIDDEN->{
                            state = "HIDDEN"
                            dismiss()
                            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        }
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }

            })
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)
        setListener()
    }

    private fun initUI(view: View) {
        fNote1 = view.findViewById(R.id.fNote1)
        fNote2 = view.findViewById(R.id.fNote2)
        fNote3 = view.findViewById(R.id.fNote3)
        fNote4 = view.findViewById(R.id.fNote4)
        fNote5 = view.findViewById(R.id.fNote5)
        fNote6 = view.findViewById(R.id.fNote6)
        fNote7 = view.findViewById(R.id.fNote7)
        fNote8 = view.findViewById(R.id.fNote8)
        fNote9 = view.findViewById(R.id.fNote9)

        imgNote1 = view.findViewById(R.id.imgNote1)
        imgNote2 = view.findViewById(R.id.imgNote2)
        imgNote3 = view.findViewById(R.id.imgNote3)
        imgNote4 = view.findViewById(R.id.imgNote4)
        imgNote5 = view.findViewById(R.id.imgNote5)
        imgNote6 = view.findViewById(R.id.imgNote6)
        imgNote7 = view.findViewById(R.id.imgNote7)
        imgNote8 = view.findViewById(R.id.imgNote8)
        imgNote9 = view.findViewById(R.id.imgNote9)
    }

    private fun setListener(){
        fNote1.setOnClickListener{
            imgNote1.setImageResource(R.drawable.ic_tick)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            imgNote8.setImageResource(0)
            imgNote9.setImageResource(0)
            selectedColor = "#C8A2C8"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Soft")
            intent.putExtra("selectedColor",selectedColor)

            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
        fNote2.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(R.drawable.ic_tick)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            imgNote8.setImageResource(0)
            imgNote9.setImageResource(0)
            selectedColor = "#FF6B6B"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","SoftCoral")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            }

        fNote3.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(R.drawable.ic_tick)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            imgNote8.setImageResource(0)
            imgNote9.setImageResource(0)
            selectedColor = "#FFDAB9"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","SoftPeach")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            }
        fNote4.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(R.drawable.ic_tick)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            imgNote8.setImageResource(0)
            imgNote9.setImageResource(0)
            selectedColor = "#708090"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","CoolSlate")
            intent.putExtra("selectedColor",selectedColor)


            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            }
        fNote5.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(R.drawable.ic_tick)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            imgNote8.setImageResource(0)
            imgNote9.setImageResource(0)
            selectedColor = "#D3D3D3"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","GentleGray")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            }
        fNote6.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(R.drawable.ic_tick)
            imgNote7.setImageResource(0)
            imgNote8.setImageResource(0)
            imgNote9.setImageResource(0)
            selectedColor = "#C2B280"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","Warm")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            }
        fNote7.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(R.drawable.ic_tick)
            imgNote8.setImageResource(0)
            imgNote9.setImageResource(0)
            selectedColor = "#B87333"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","LightCooper")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            }
        fNote8.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            imgNote8.setImageResource(R.drawable.ic_tick)
            imgNote9.setImageResource(0)
            selectedColor = "#B2C7A9"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","LightSage")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            }
        fNote9.setOnClickListener{
            imgNote1.setImageResource(0)
            imgNote2.setImageResource(0)
            imgNote3.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            imgNote8.setImageResource(0)
            imgNote9.setImageResource(R.drawable.ic_tick)
            selectedColor = "#DAA520"
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action","MutedGold")
            intent.putExtra("selectedColor",selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            }

    }

}